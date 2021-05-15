import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


//This array is going to have the list of all paths
const routes: Routes = [
  // {
    // example: path:'',
    // example: redirectTo: '',
    // example: pathMatch: 'full'
  //},

  // {
    // example: path:'componnent directory',
    // component: ComponentName
  //},

  // {
    // example: path:'another component directory',
    // component: AnotherComponentName
  //},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
