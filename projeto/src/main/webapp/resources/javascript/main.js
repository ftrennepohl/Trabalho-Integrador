setNavBarPadding();

window.addEventListener("resize", setNavBarPadding);

function setNavBarPadding(){
    let navHeight = document.getElementsByTagName("nav")[0].offsetHeight;
    navHeight = navHeight;
    document.getElementById("main-content-wrapper").style.paddingTop = navHeight + "px";
}

/*function pagination(){
    let tarefasContainer = document.getElementById("tarefas-container");
    let tarefas = document.getElementById("tarefas");
    let tarefasWidgets = tarefas.querySelectorAll("div");
    let widgetKeys = Object.keys(tarefasWidgets);

    console.log(widgetKeys);

    let i = tarefasWidgets.length - 1

    while(tarefas.offsetHeight > tarefasContainer.offsetHeight){
        tarefasWidgets[i].remove();
        i--;
    }

    //tarefasWidgets.forEach((currentValue, index) => tarefas.appendChild(tarefasWidgets[index]))
}
*/

function setContentDisplaytoNone(){
    const contents = document.getElementsByClassName("content");
    for(let i=0; i < contents.length; i++){
        contents[i].classList.remove("active");
    }
}

function activateContent(content){
    setContentDisplaytoNone();
    document.getElementById(content).classList.add("active");
}

function activateAddButton(){
    const contents = new Map([["tarefas", "cadastro-tarefas"], ["processos", "cadastro-processos"], ["clientes", "cadastro-clientes"], ["financeiro", "cadastro-movimentacao"]]);
    let activeContent = document.getElementsByClassName("active content")[0].id;
    let cadastro = contents.get(activeContent);
    if (cadastro == null) return;
    activateContent(cadastro);
}

function getClienteInputs(){
	let cadastroClientes = document.getElementById("cadastro-clientes");
	let inputs = cadastroClientes.getElementsByTagName("input");
	let valores = [];
	for(let i = 0; i < inputs.length; i++){
		if (inputs.item(i).value !== null) valores.push(inputs.item(i).value);
	}
	arquivo = JSON.stringify(valores);
}
