import React from "react";
import { useState,useEffect } from "react";
const RepresentativeReport=(props)=>{
    const [list,setlist]=useState([]);
  const fetchRetailerreports = async () => {
  const response = await fetch(
      `http://localhost:8080/api/v1/retailer/${props.id}/orders`
    );
   const data = await response.json();
   console.log(data.content);
    setlist(data);
  };
  useEffect(() => {
    fetchRetailerreports();
  }, []);
    return(
        <table className="table table-hover">
        <thead>
            <tr>
                <td>Date</td>
                <td>Total Retailers Met</td>
                <td>New Retailer Onbaorded</td>
                <td>Previous Retailers Met</td>
                <td>Orders Placed</td>
                <td>Comments</td>
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