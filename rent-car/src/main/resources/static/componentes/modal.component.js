import {
  c,
  h,
  useState,
  useProp,
  useHost,
  useRef,
  useEffect,
  usePromise,
  render,
  useEvent,
} from "https://cdn.skypack.dev/atomico";
import { html } from "https://cdn.skypack.dev/atomico/html";

const modalManageComponent = ({ title, saveBtnName, fieldsDataSource }) => {
  const [isOpen, setIsOpen] = useState("");
  const [state, setState] = useState({});

  const dispatchEvent = useEvent("resultChange", {
    bubbles: false,
    composed: false,
  });
  const host = useHost();
  const ref = useRef();

  useEffect(() => {
    Array.from(ref?.current?.children).forEach((e) => e.remove());
    const formTemp = host.current.querySelector("template");
    const formElm = formTemp.content.cloneNode(true);
    ref.current.appendChild(formElm);

    if (!isOpen) return;

    //Object set datasource
    fieldsDataSource
      .filter(({ field }) => ref.current.querySelector(`[name='${field}']`))
      .map((config) => {
        let fieldElm = ref.current.querySelector(`[name='${config.field}']`);
        return { config, fieldElm };
      })
      .forEach(async ({ config, fieldElm }) => {
        const { urlData, optionType, getItemInfo } = config;
        const data = await fetchFieldData(urlData);
        setOptionsField(optionType, data, getItemInfo, fieldElm);
      });

    //Set inital values
    Object.entries(state)
      .filter(([key]) => ref.current.querySelector(`[name='${key}']`))
      .forEach(([key, value]) => {
        ref.current
          .querySelector(`[name='${key}']`)
          .setAttribute("value", value);
      });
  }, [isOpen]);

  const openModal = (item) => {
    setIsOpen("is-active");
    setState(item || {});
  };

  const submit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    dispatchEvent(Object.fromEntries(formData.entries()));
    e.target.reset();
    setIsOpen("");
  };

  return html`
    <host openModal=${openModal} closeModal=${() => setIsOpen("")}>
      <div class="modal ${isOpen}">
        <div class="modal-background"></div>
        <div class="modal-card">
          <header class="modal-card-head">
            <p class="modal-card-title">${title}</p>
            <button
              onclick=${() => setIsOpen("")}
              class="delete"
              aria-label="close"
            ></button>
          </header>
          <form onsubmit=${submit} id="car-form" data-type="create">
            <section ref=${ref} class="modal-card-body"></section>
            <footer class="modal-card-foot">
              <button
                id="submitBtn"
                type="submit"
                class="button mr-1 is-success"
              >
                ${saveBtnName}
              </button>
              <button
                onclick=${() => setIsOpen("")}
                aria-label="close"
                id="cancelBtn"
                type="button"
                class="button"
              >
                Cancelar
              </button>
            </footer>
          </form>
        </div>
      </div>
    </host>
  `;
};

modalManageComponent.props = {
  title: { type: String, value: "" },
  saveBtnName: { type: String, value: "Guardar" },
  fieldsDataSource: { type: Array, value: [] },
};

customElements.define("modal-manage-component", c(modalManageComponent));

async function fetchFieldData(urlData) {
  let response = await fetch(urlData);
  let { items } = await response.json();

  return Promise.resolve(items);
}

function setOptionsField(optionTag, data, getItemInfo, parent) {
  const options = createOptionHtml(optionTag, data, getItemInfo, parent);
  parent.insertAdjacentHTML("afterbegin", options);
  parent?.parentElement?.classList?.remove("is-loading");
}

function createOptionHtml(optionTag, data, getItemInfo, parent) {
  const selectedValue = parent.getAttribute("value");
  const options = data
    .map(getItemInfo)
    .map(
      ({ value, text }) =>
        `<${optionTag} ${
          value == selectedValue ? "selected" : ""
        } value=${value}>${text}</${optionTag}>`
    )
    .join("");

  const result = [
    `<${optionTag} value="">Seleccione opcion</${optionTag}>`,
    options,
  ];
  return result.join("");
}
