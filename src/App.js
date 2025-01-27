import { Route, Routes } from 'react-router-dom';
import './App.css';
import './component/Header'
import Header from './component/Header';
import Home from './component/Home';
import Service from './component/Service';
import Product from './component/Product';
import Contactus from './component/Contactus';
import Topproduct from './component/Topproduct';
import Newproduct from './component/Newproduct';
import Notfound from './component/Notfound';
import Users from './component/Users';

function App() {
  return (
    <div>
      <Header></Header>
      <Routes>
        <Route path='/' Component={Home}></Route>
        <Route path='service' Component={Service}></Route>
        <Route path='users/:userid' Component={Users}></Route>
        <Route path='product' Component={Product}>
            <Route path='/product/latestproduct' Component={Newproduct}></Route>
            <Route path='/product/toprated' Component={Topproduct}></Route>
        </Route>
        <Route path='contactus' Component={Contactus}></Route>
        <Route path='*' Component={Notfound}></Route>
      </Routes>
      
    </div>
 
  );
}

export default App;
