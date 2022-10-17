import DisplayList from "../GeneralPages/DisplayList";
import React, { useEffect, useState } from "react";

const AssociatedRetailers = (props) => {
  const dummy = [
    {
      name: "Retailer1",
      phone: "888888888",
      UID: "TestRetailer1",
      Address: {
        street: "Jubliee Hills",
        city: "Hyd",
        pincode: "500036",
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
        pincode: "98101",
        state: "Washington",
        country: "US",
      },
    },
  ];

  const [retailers, setRetailer] = useState();

  useEffect(() => {
    async () => {
      console.log("hello");
      const response = await fetch(
        "http://192.168.29.5:8080/api/v1/manager/1/representatives"
      );
      if (!response.ok) {
        console.log("ERROR");
        return;
      }
      const data = await response.json();

      setRetailer(data);
    };
  }, []);
  return (
    <>
      <DisplayList table={dummy} type={props.type}></DisplayList>
    </>
  );
};
export default AssociatedRetailers;
