const backendUrl =
  "https://gb178d489bce612-gls8470k33jatdxg.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client";

const columns = [
  { columnName: "#", rowFn: ({ id }) => id },
  { columnName: "Nombre", rowFn: ({ name }) => name },
  { columnName: "Email", rowFn: ({ email }) => email },
  { columnName: "Edad", rowFn: ({ age }) => age },
  {
    actionName: "show",
    icon: "edit",
    isAction: true,
    rowFn: (item) => {
      const modal = document.querySelector("modal-manage-component");
      modal.openModal(item);
      const modalResut = async ({ detail }) => {
        await fetch(backendUrl, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(detail),
        });
        const gridTable = document.querySelector("grid-component");
        gridTable.reloadTable();
        modal.closeModal();
        modal.removeEventListener("resultChange", modalResut);
      };
      modal.addEventListener("resultChange", modalResut);
    },
  },
  {
    actionName: "show",
    icon: "delete",
    classBtn: "is-danger",
    isAction: true,
    rowFn: async ({ id, brand: name }) => {
      const result = await Swal.fire({
        title: "Eliminar Cliente",
        icon: "question",
        text: `Esta seguro que quiere eliminar el cliente ${name}`,
        showDenyButton: true,
        confirmButtonText: "Aceptar",
        denyButtonText: `Cancelar`,
      });

      if (result.isDenied) return;

      await fetch(`${backendUrl}?id=${id}`, {
        method: "DELETE",
      });

      const gridTable = document.querySelector("grid-component");
      gridTable.reloadTable();
    },
  },
];

const gridTable = document.querySelector("grid-component");
gridTable.urldata = backendUrl;
gridTable.columns = columns;
await gridTable.updated;
gridTable.reloadTable();

const btnCrearMensaje = document.getElementById("crear-cliente");
btnCrearMensaje.onclick = async () => {
  const modal = document.querySelector("modal-manage-component");
  await modal.updated;
  modal.openModal();
  const modalResut = async ({ detail }) => {
    await fetch(backendUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(detail),
    });
    gridTable.reloadTable();
    modal.closeModal();
    modal.removeEventListener("resultChange", modalResut);
  };
  modal.addEventListener("resultChange", modalResut);
};
