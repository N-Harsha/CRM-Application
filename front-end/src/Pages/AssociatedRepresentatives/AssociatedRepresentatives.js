import React from "react";
import { useState,useEffect } from "react";
import RepresentativeList from "./RepresentativeList";
const AssociatedRepresentatives=()=>{
    const [list,setlist]=useState([]);
  const fetchRepresentativelist = async () => {
  const response = await fetch(
      "http://192.168.29.5:8080/api/v1/manager/1/representatives"
    );
   const data = await response.json();
    setlist(data);
  };

  useEffect(() => {
    fetchRepresentativelist();
  }, []);
    return (
        <RepresentativeList list={list}/>
    );
};
export default AssociatedRepresentatives;