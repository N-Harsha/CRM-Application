import React from "react";
import { useState,useEffect } from "react";
const RepresentativeReport=(props)=>{
    const [list,setlist]=useState([]);
  if(props.type==="rep"){
  
  const fetchRetailerorders = async () => {
  const response = await fetch(
      `http://192.168.29.5:8080/api/v1/retailer/${props.id}/orders`
    );
   const data = await response.json();
   console.log(data);
    setlist(data);
  };


  useEffect(() => {
    fetchRetailerorders();
  }, []);}
    return(
        <table className="table table-hover">
        <thead>
            <tr>
                <td>Order Id</td>
                <td>Product Name</td>
                <td>Supplier Name</td>
                <td>Amount(in Rs.)</td>
            </tr>
        </thead>
        <tbody>
            {list.map((data)=><tr key={data.id}>
                <td>{data.id}</td>
                <td>{data.productName}</td>
                <td>{data.supplierName}</td>
                <td>{data.amount}</td>
            </tr>)}
        </tbody>
        </table>
    );

};
export default RepresentativeReport;