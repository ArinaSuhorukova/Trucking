import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import {changeLoggedIn} from "./actions/user";
import { BrowserRouter } from 'react-router-dom';
import reducers from './redusers/redusers';
import {parseToken, setToken} from "./utils/tokenParser";

const loggedIn=parseToken();
const store = createStore(reducers,loggedIn);
// store.subscribe(()=>{
//     // localStorage.setItem('accessItem',store.getState().loggedIn);
//     localStorage.setItem('loggedIn',store.getState().loggedIn);
// });
store.subscribe(setToken);

ReactDOM.render(
    <Provider store={store}>
        <BrowserRouter>
            <App/>
        </BrowserRouter>
    </Provider>
    , document.getElementById('root'));


// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
