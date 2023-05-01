import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AlertsComponent } from './components/alerts/alerts.component';
import { AccordionComponent } from './components/accordion/accordion.component';
import { BadgesComponent } from './components/badges/badges.component';
import { BreadcrumbsComponent } from './components/breadcrumbs/breadcrumbs.component';
import { ButtonsComponent } from './components/buttons/buttons.component';
import { CardsComponent } from './components/cards/cards.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { ChartsApexchartsComponent } from './components/charts-apexcharts/charts-apexcharts.component';
import { ChartsChartjsComponent } from './components/charts-chartjs/charts-chartjs.component';
import { FormsEditorsComponent } from './components/forms-editors/forms-editors.component';
import { FormsElementsComponent } from './components/forms-elements/forms-elements.component';
import { FormsLayoutsComponent } from './components/forms-layouts/forms-layouts.component';
import { IconsBootstrapComponent } from './components/icons-bootstrap/icons-bootstrap.component';
import { IconsBoxiconsComponent } from './components/icons-boxicons/icons-boxicons.component';
import { IconsRemixComponent } from './components/icons-remix/icons-remix.component';
import { ListGroupComponent } from './components/list-group/list-group.component';
import { ModalComponent } from './components/modal/modal.component';
import { PaginationComponent } from './components/pagination/pagination.component';
import { ProgressComponent } from './components/progress/progress.component';
import { SpinnersComponent } from './components/spinners/spinners.component';
import { TablesDataComponent } from './components/tables-data/tables-data.component';
import { TablesGeneralComponent } from './components/tables-general/tables-general.component';
import { TabsComponent } from './components/tabs/tabs.component';
import { TooltipsComponent } from './components/tooltips/tooltips.component';
import { PagesBlankComponent } from './pages/pages-blank/pages-blank.component';
import { PagesContactComponent } from './pages/pages-contact/pages-contact.component';
import { PagesError404Component } from './pages/pages-error404/pages-error404.component';
import { PagesFaqComponent } from './pages/pages-faq/pages-faq.component';
import { PagesLoginComponent } from './pages/pages-login/pages-login.component';
import { PagesRegisterComponent } from './pages/pages-register/pages-register.component';
import { UsersProfileComponent } from './pages/users-profile/users-profile.component';
import { InsuranceComponent } from "./pages/insurance/insurance.component";
import { InsuranceTypeComponent } from './pages/insurance/insurance-type/insurance-type.component';
import { InsuranceTransactionComponent } from './pages/insurance/insurance-transaction/insurance-transaction.component';
import { InsuranceDetailComponent } from './pages/insurance/insurance-detail/insurance-detail.component';
import { InsuranceClientComponent } from './pages/insurance/insurance-client/insurance-client.component';
import { InsuranceDetailClientComponent } from './pages/insurance/insurance-detail-client/insurance-detail-client.component';
import { InsuranceTransactionClientComponent } from './pages/insurance/insurance-transaction-client/insurance-transaction-client.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  {path: 'myInsurance', component: InsuranceClientComponent},
  {path : 'myInsuranceDetail',component: InsuranceDetailClientComponent},
  {path: 'myInsuranceTransaction',component:InsuranceTransactionClientComponent},
  { path: 'insurance', component: InsuranceComponent},
  {path:'insuranceTransaction', component:InsuranceTransactionComponent},
  { path: 'insuranceType', component: InsuranceTypeComponent},
  {path:'insuranceDetail', component: InsuranceDetailComponent},
  { path: 'dashboard', component: DashboardComponent },
  { path: 'pages-error404', component: PagesError404Component },
  { path: 'pages-login', component: PagesLoginComponent },
  { path: 'pages-register', component: PagesRegisterComponent },
  { path: 'user-profile', component: UsersProfileComponent },
  {path :'**', component: PagesError404Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
