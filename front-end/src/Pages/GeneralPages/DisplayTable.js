import React, { useState } from "react";
import TableItem from "./TableItem";
import AddButton from "./AddButton";
import "./DisplayTable.css";
import { useNavigate } from "react-router-dom";
const DisplayTable = (props) => {
  const [dummy,setdummy] =useState( [
    {
      name: "Retailer1",
      phone: "888888888",
      UID: "TestRetailer1",
      Address: {
        street: "Jubliee Hills",
        city: "Hyd",
        pincode:"500036",
        state: "Telangana",
        country: "India",
      },
    },
    {
      name: "Retailer2",
      phone: "888888888",
      UID: "TestRetailer2",
      Address: {
        street: "White Center",
        city: "Seattle",
        pincode:"98101",
        state: "Washington",
        country: "US",
      },
    },
  ]);
  const navigate=useNavigate();
  const clickHandler=()=>{
    console.log("clickHandler")
    navigate("/NewRetailer/new");
  }
  return (
    <div>
      <AddButton title={props.type} onClick={clickHandler} />
      <table className="crmTable table table-striped">
        <thead>
          <tr>
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
          {dummy.map((data) => (
            <TableItem key={data.UID  } item={data} />
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default DisplayTable;
