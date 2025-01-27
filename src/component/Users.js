import React from 'react'
import { useParams } from 'react-router-dom'

function Users() {
    const param=useParams();
  return (
    <div>Welcome Users: {param.userid}</div>
  )
}

export default Users