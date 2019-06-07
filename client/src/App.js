import React from 'react';
import {Router, Route, Redirect} from 'react-router'
import createBrowserHistory from './helpers/history';
import UserComponent from "./components/forms/UserComponent";
import CarComponent from "./components/forms/CarComponent";
import CarListComponent from "./components/pages/CarListComponent";
import ProductListComponent from "./components/pages/ProductListComponent";
import UserListComponent from "./components/pages/UserListComponent";
import ProductComponent from "./components/forms/ProductComponent";
import ClientComponent from "./components/forms/ClientComponent";
import LoginForm from "./components/forms/LoginForm";
import Home from "./components/home/Home"
import {connect} from 'react-redux';
import ProtectedRoute from "./components/ProtectedRoute";
import ClientListComponent from "./components/pages/ClientListComponent";
import WaybillListComponent from "./components/pages/WaybillListComponent";
import Navigation from "./components/Navigation";
import WarehouseListComponent from "./components/pages/WarehouseListComponent";
import WarehouseComponent from "./components/forms/WarehouseComponent";
import UserFields from "./components/forms/UserFields";

class App extends React.Component {
    constructor(props){
        super(props);
    }
    render() {
        return (
            <Router history={createBrowserHistory}>
                <Navigation/>
                <Route path="/home" component={Home}/>
                <Route path="/user/:id" component={UserComponent}/>
                <Route path="/car/:id" component={CarComponent}/>
                <Route path="/product/:id" component={ProductComponent}/>
                <Route path="/cars" component={CarListComponent}/>
                <Route path="/products" component={ProductListComponent}/>
                <Route path="/client/:id" component={ClientComponent}/>
                <Route path="/login" component={LoginForm}/>
                <Route path="/clients" component={ClientListComponent}/>
                <Route path="/waybills" component={WaybillListComponent}/>
                <Route path="/test" component={UserFields}/>
                <ProtectedRoute exact path="/driver/:id" allowed='SYSADMIN' component={UserComponent}/>
                <ProtectedRoute exact path="/users" allowed='SYSADMIN' component={UserListComponent}/>
            </Router>
        );
    }
}

export default connect(
    state => ({
        loggedIn: state.loggedIn,
    })
)(App);