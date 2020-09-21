import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// registrar modulo para manejo de formularios
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChatComponent } from './chat/chat.component';
import { InicioComponent } from './inicio/inicio.component';
import { StylesComponent } from './styles/styles.component';
import { RegistroComponent } from './registro/registro.component';

@NgModule({
  declarations: [
    AppComponent,
    ChatComponent,
    InicioComponent,
    StylesComponent,
    RegistroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
