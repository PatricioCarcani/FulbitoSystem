import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
// importar componentes propios
import { InicioComponent } from './inicio/inicio.component';
import { ChatComponent } from './chat/chat.component';
import { StylesComponent } from "./styles/styles.component";
import { RegistroComponent } from './registro/registro.component';

const routes: Routes = [
  {path: 'inicio', component: InicioComponent},
  // redirigre index a chat
  //{path: '', redirectTo: 'chat', pathMatch: 'full'},
  {path: 'chat', component: ChatComponent},

  {path: 'registro', component: RegistroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
