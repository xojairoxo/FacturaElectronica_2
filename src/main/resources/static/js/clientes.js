class Clientes {
    dom;
    modal;

    state;  // state variables: entities, entity, mode (Add|Edit)

    constructor(){
        // this.state = {'entities': [], 'entity': this.emptyEntity(), 'mode':'A'};
        // this.dom=this.render();
        // this.modal = new bootstrap.Modal(this.dom.querySelector('#modal'));
        // this.dom.querySelector("#countries #create").addEventListener('click',this.makenew);
        // this.dom.querySelector("#countries #search").addEventListener('click',this.search);
        // this.dom.querySelector('#countries #modal #form #apply').addEventListener('click',this.add);

        this.state = {'entities': new Array(), 'entity': this.emptyEntity(), 'mode':'A'};
        this.dom=this.render();
        this.modal = new bootstrap.Modal(this.dom.querySelector('#modal'));

    }
    render=()=>{
        const html= `
            ${this.renderList()}
            ${this.renderModal()}
        `;
        var rootContent= document.createElement('div');
        rootContent.id='clientes';
        rootContent.innerHTML=html;
        return rootContent;
    }

    showModal= async ()=>{
        // Load entity data into modal form
        this.modal.show();
    }

    emptyEntity=()=>{
        // idcliente INT AUTO_INCREMENT PRIMARY KEY,
        //     identificacionc varchar(20) not null,
        //     nombrec varchar(30) not null,
        //     correo varchar(20) not null,
        //     telefono INTEGER not null,
        //     proveedorc varchar(20) not null
          return {
            'identificacionc':'',
            'nombrec':'',
            'correo':'',
            'telefono':'',
          };
    }
    renderList = () => {
        return `
        <div id="list" class="container">     
            <div class="card bg-light">
                <h4 class="card-title mt-3 text-center">countries</h4>    
                <div class="card-body mx-auto w-75" >
                    <form id="form">
                        <div class="input-group mb-3">
                            <span class="input-group-text">Name</span>
                            <input id="name" type="text" class="form-control">
                            <div class="btn-toolbar">
                                <div class="btn-group me-2">
                                    <button type="button" class="btn btn-primary" id="search">Search</button>
                                </div>
                                <div class="btn-group me-2">
                                    <button type="button" class="btn btn-primary" id="create">Create</button>
                                </div>                        
                            </div>  
                        </div>
                    </form>

                    <div class="table-responsive" style="max-height: 300px; overflow: auto">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Identificacion</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Telefono</th>
                                </tr>
                            </thead>
                            <tbody id="listbody">
                            </tbody>
                        </table>
                    </div>                 
                </div>
            </div>
        </div>
    `;
    }

    list=()=>{
      const request = new Request(`${backend}/clientes/findClientesByProveedor?id=${globalstate.user.identificacionu}`,
          { method: 'GET', headers: {'Content-Type': 'application/json'} });
        (async () => {
            const response = await fetch(request);
            if (!response.ok) {
                errorMessage(response.status); return; }
            var clientes = await response.json();
            this.state.entities = clientes;
                    var listing=this.dom.querySelector("#clientes #list #listbody");
                    listing.innerHTML="";
                    this.state.entities.forEach( e=>this.row(listing,e));
        }
        )();
    }
    row = (list, c) => {
        var tr = document.createElement("tr");
        tr.innerHTML = `
         <td>${c.identificacionc}</td>
        <td>${c.nombrec}</td>
        <td>${c.correo}</td>
        <td>${c.telefono}</td>
        <td>
            <button type="button" class="btn btn-danger btn-sm">Delete</button>
            <button type="button" class="btn btn-danger btn-sm">Editar</button>
        </td>
    `;
        list.append(tr);
        // Obtener referencia al botón "Delete"
        var deleteButton = tr.querySelector(".btn-danger");

        // //Agregar event listener al botón "Delete"
        // deleteButton.addEventListener("click", () => {
        //     this.deleteCountry(c.name);
        // });
    }








    renderModal =()=> {
        return `
        <div id="modal" class="modal fade" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header" >
                        <img class="img-circle" id="img_logo" src="images/logo.png" style="max-width: 50px; max-height: 50px" alt="logo">
                        <span style='margin-left:4em;font-weight: bold;'>Country</span> 
                       <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form id="form" >
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="country-name">Country Name</label>
                            <input type="text" class="form-control" id="country-name" placeholder="Enter country name">
                        </div>
                        <div class="form-group">
                            <label for="country-capital">Capital</label>
                            <input type="text" class="form-control" id="country-capital" placeholder="Enter capital">
                        </div>
                        <div class="form-group">
                            <label for="country-population">Population</label>
                            <input type="number" class="form-control" id="country-population" placeholder="Enter population">
                        </div>
                        <div class="form-group">
                            <label for="country-area">Area</label>
                            <input type="number" class="form-control" id="country-area" placeholder="Enter area">
                        </div>
                        <div class="form-group">
                            <label for="country-latlng">Latitude and Longitude</label>
                            <input type="text" class="form-control" id="country-latlng" placeholder="Enter latitude,longitude">
                        </div>
                        <div class="form-group">
                            <label for="country-flag">Flag URL</label>
                            <input type="text" class="form-control" id="country-flag" placeholder="Enter flag URL">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button id="apply" type="button" class="btn btn-primary" >Aplicar</button>
                    </div>
                    </form>                 
                </div>         
            </div>          
        </div>      
        `;
    }
}