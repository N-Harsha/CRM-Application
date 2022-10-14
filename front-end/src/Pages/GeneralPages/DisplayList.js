import ListItem from "./ListItem";
import React from "react";
import "./DisplayList.css";
const DisplayList=(props)=>{

    return(
        <div>
      <table className="table table-hover">
        <thead>
          <tr key="TableHead">
            <th>{props.type} Name</th>
            <th>Phone</th>
            <th>{props.type} ID</th>
            {props.type==="Distributor" && <th>ERP</th>}
            <th>Street</th>
            <th>City</th>
            <th>Pin Code</th>
            <th>state</th>
            <th>Country</th>
          </tr>
        </thead>
        <tbody>
          {props.table.map((data) => (
            <ListItem key={data.UID} item={data} type="Retailer"></ListItem>
          ))}
        </tbody>
      </table>
    </div>
    );
};
export default DisplayList;