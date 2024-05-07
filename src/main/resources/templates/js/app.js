class App {
    dom;
    modal; // login modal
    state;  // state variables: if any


    constructor() {
        this.state = {};
        // this.dom = this.render();
        // this.modal = new bootstrap.Modal(this.dom.querySelector('#app>#modal'));
        // this.dom.querySelector('#app>#modal #apply').addEventListener('click', e => this.login());
        // this.renderBodyFiller();
        // this.renderMenuItems();
    }

    render=()=>{
        const html= `
            ${this.renderMenu()}
            ${this.renderBody()} 
            ${this.renderFooter()}
            ${this.renderModal()}
        `;
        var rootContent= document.createElement('div');
        rootContent.id='app';
        rootContent.innerHTML=html;
        return rootContent;
    }

    renderMenu=()=>{
        return `
        <nav id="menu" class="navbar navbar-expand-lg p-0 navbar-dark bg-dark">
          <div class="container-fluid">
            <a class="navbar-brand  font-italic font-weight-light  text-info" href="#">
                <img src="images/logo.png" class="logo rounded-circle" alt="logo">
                countries
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menuCollapse">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div id="menuCollapse" class="collapse navbar-collapse" >
              <ul class="navbar-nav me-auto mb-2 mb-lg-0" id='menuItems'>
              </ul>
            </div>
          </div>
        </nav>
        `;
    }
    renderBody=()=>{
        return `
        <div id="body">   
        </div>          
    `;
    }
    renderFooter=()=>{
        return `
        <footer id="footer" class="bg-dark text-white mt-4 w-100 fixed-bottom">
            <div class="container-fluid py-2">

                <div class="row">
                    <div class="col-md-2"><h5>Total Soft Inc.</h5></div>
                    <div class="col-md-7"><h4>
                        <i class="fab fa-twitter"></i>
                        <i class="fab fa-facebook"></i>
                        <i class="fab fa-instagram"></i></h4>
                    </div>
                    <div class="col-md-3 text-right small align-self-end">©2023 Tsf, Inc.</div>
                </div>
            </div>
        </footer> 
    `;
    }

    renderModal=()=>{
        return `
        <div id="modal" class="modal fade" tabindex="-1">
           <div class="modal-dialog">
               <div class="modal-content">
                   <div class="modal-header" >
                       <img class="img-circle" id="img_logo" src="images/user.png" style="max-width: 50px; max-height: 50px" alt="logo">
                       <span style='margin-left:4em;font-weight: bold;'>Login</span> 
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                   </div>
                   <form id="form" >
                   <div class="modal-body">
                       <div class="input-group mb-3">
                           <span class="input-group-text">Id</span>
                           <input type="text" class="form-control" id="identificacion" name="identificacion">
                       </div>  
                       <div class="input-group mb-3">
                           <span class="input-group-text">clave</span>
                           <input type="password" class="form-control" id="clave" name="clave">
                       </div>      
                   </div>
                   <div class="modal-footer">
                       <button id="apply" type="button" class="btn btn-primary" id="apply">Login</button>
                   </div>
                   <div class="input-group">
                       <span style="font-style: italic; margin-left: 2em;">No tiene cuenta? ... </span>
                       <a id="register" class="btn btn-info btn-block" style="margin-bottom: 15px; background-color: white; color:red; border:1px solid red" href="#">Registrese aquí</a>
                   </div>                
                   </form>                 
               </div>         
           </div>          
       </div>   
    `;
    }


    renderBodyFiller=()=>{
        var html= `
        <div id='bodyFiller' style='margin-left: 10%; margin-top:100px; width: 80%; text-align: center; font-size: 1.5em'>
            <p>Informacón de los paises del mundo.</p>
            <img src="../../static/images/headerLogo.jpg" class="filler rounded-circle" alt="headerLogo.jpg">
        </div>
    `;
        this.dom.querySelector('#app>#body').replaceChildren();
        this.dom.querySelector('#app>#body').innerHTML=html;
    }

    renderMenuItems=()=> {

    }

    login = async () => {
        const form = document.querySelector("#form");
        const formData = new FormData(form);
        const candidate = Object.fromEntries(formData.entries());
        candidate.rol = '';
        try {
            const response = await fetch(backend, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(candidate)
            });

            if (response.ok) {
                const userData = await response.json();
                globalstate.user = userData;
                this.modal.hide();
                this.renderMenuItems();
            } else {
                // Handle error response
                console.error('Login failed:', response.statusText);
                errorMessage(response.status);
            }
        } catch (error) {
            console.error('Login error:', error);
            errorMessage('Network error');
        }
    }

}