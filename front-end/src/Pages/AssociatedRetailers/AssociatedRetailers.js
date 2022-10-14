import DisplayList from "../GeneralPages/DisplayList";
import React from "react";

const AssociatedRetailers=(props)=>{
    const dummy = [
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
      ];
    return(
        <>
        <DisplayList table={dummy} type={props.type}></DisplayList>
        </>
    );
};
export default AssociatedRetailers;