import React from 'react'
import { Link, Outlet } from 'react-router-dom'

function Product() { //component - contoller
let product = [
    {
    name:'tv',
    cost:67876,
    company:'sony'
    },
    {
        name:'laptop',
        cost:87654,
        company:'dell'
    },
    {
        name:'fan',
        cost:7878,
        company:'crompton'
    }
]
return (<>
 
    <hr/>
    <nav>
        <ul>
          <Link to="/product/latestproduct">
          latestproduct
          </Link>
          <Link to="/product/toprated">
          toprated
          </Link>
         <hr></hr>
         <Outlet></Outlet>
         <div>Fetch the product from somewhere</div>
         <table>
            <thead>
                <tr>
                    <th>name</th>
                    <th>cost</th>
                    <th>company</th>
                </tr>
            </thead>
            <tbody>
                {
                    product.map((p,key)=>{
                        return <>
                                <tr>
                                <td>{p.name}</td>
                                <td>{p.cost}</td>
                                <td>{p.company}</td>
                                </tr>
                                </>

                        
                    })
                    }
                  
                
            </tbody>
         </table>
        </ul>
      </nav>
    </>)
}

export default Product