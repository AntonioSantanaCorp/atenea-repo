import { c, h, useState } from "https://cdn.skypack.dev/atomico";
import { html } from "https://cdn.skypack.dev/atomico/html";

const tableComponent = ({ columns, urldata }) => {
  const tableHeader = getTableHeader(columns);
  const [tableRows, setTableRows] = useState(null);
  const getData = async () => {
    Swal.fire({
      title: "Por favor espere",
      text: "Consultando datos",
      didOpen: () => Swal.showLoading(),
    });
    let data = await getTableData(urldata);
    setTableRows(getTableRows(data || [], columns));
    Swal.close();
  };

  return html`<host reloadTable=${getData}>
    <table class="table is-striped is-hoverable is-fullwidth">
      <thead>
        ${tableHeader}
      </thead>
      <tbody>
        ${tableRows == null ? "loading" : tableRows}
      </tbody>
    </table>
  </host>`;
};

tableComponent.props = {
  urldata: { type: String, value: "" },
  columns: { type: Array, value: [] },
};

customElements.define("grid-component", c(tableComponent));

//Helpers
const hasActionColumn = (columns) => columns.some((config) => config?.isAction);
const getInfoColumns = (columns) =>
  columns.filter((column) => !column?.isAction);
const getActionColumns = (columns) =>
  columns.filter((column) => column?.isAction);

//Create DOM Functions
async function getTableData(urldata) {
  const res = await fetch(urldata);
  const { items } = await res.json();
  return await Promise.resolve(items);
}

function getTableHeader(columns) {
  const columsHeader = getInfoColumns(columns)
    .map(({ columnName }) => columnName)
    .map((col) => h("th", { class: "scope" }, col));

  if (hasActionColumn(columns)) columsHeader.push(h("th", null, "Actions"));

  return h("tr", null, columsHeader);
}

function getTableRows(data, columns) {
  const rows = [];
  const rowsFnsData = getInfoColumns(columns).map(({ rowFn }) => rowFn);
  const rowsActions = getActionColumns(columns);

  //Info rows
  for (const item of data) {
    const cells = rowsFnsData.map((rowFn) => rowFn(item));
    const tdRows = cells.map((cell) => h("td", null, cell));
    const actionsContaner = setActionsContainer(rowsActions, item);
    const tdRowsWithActions = [...tdRows, actionsContaner];

    rows.push(h("tr", null, tdRowsWithActions));
  }

  return rows;
}

function setActionsContainer(columns, item) {
  const actionButtons = columns.map((column) =>
    convertActionButton(column, item)
  );

  return h("td", null, actionButtons);
}

function convertActionButton({ rowFn, icon, classBtn }, item) {
  const iconElm = h("span", { class: "material-icons" }, icon);
  const buttonElm = h(
    "button",
    {
      class: ["button mr-1", classBtn ?? "is-info"].join(" "),
      onclick: (e) => rowFn(structuredClone(item), e),
    },
    iconElm
  );

  return buttonElm;
}
