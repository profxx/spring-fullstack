const description = document.getElementById("message-description");
const btnAdd = document.getElementById("btn-add");
const lista = document.getElementById("lista");

function convertRecadoToLi(recado) {
    return `
    <li>
        <h3>${recado.descricao}</h3>
        <p>Finalizada? ${recado.completado}</p>
    </li>
    `;
}

// Função para listar recados
function listar() {
    fetch("../recados")
        .then((response) => response.json())
        .then((jsonResponse) => {
            lista.innerHTML = jsonResponse.map(convertRecadoToLi).join("");
        })
        .catch((error) => console.log("Erro ao listar recados: " + error));
}

// Chama a função listar ao carregar a página
listar();

// Evento para adicionar novo recado
btnAdd.addEventListener("click", () => {
    fetch("../recados", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            descricao: description.value,
            completado: false 
        })
    })
    .then((response) => response.json())
    .then((item) => {
        // Adiciona o novo item na lista sem duplicar
        lista.innerHTML += convertRecadoToLi(item);
        // Limpa o campo de input
        description.value = "";
    })
    .catch((error) => console.log("Erro ao adicionar recado: " + error));
});
