import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'


function Service() {
  let [products,setProduct]=useState([]);
  useEffect(()=>{
    fetch('https://fakestoreapi.com/products')
    .then(response=>response.json())
    .then(data=>setProduct(data));
    
    
  },[]);
  // can i call the external api and get the data useEffect
   let navigate=useNavigate();
  return (<>
    <div>Service</div>
    <button onClick={()=>{navigate('/')}}>Click here to contact us</button>
    <table>
      <thead>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>cost</th>
            <th>description</th>
        </tr>
      </thead>
      <tbody>
        {
          products.map((product,index)=>{
            return <>
              <tr key={products.id}>
                  <th>{product.id}</th>
                  <th>{product.title}</th>
                  <th>{product.price}</th>
                  <th>{product.description}</th>
              </tr>
            </>
          })
        }
      </tbody>
    </table>
    </>)
}

export default Service