import React from "react";
import { useState ,useEffect} from "react";
const RepresentativeRetailers=(props)=>{
    const [list,setlist]=useState([]);
  if(props.type==="rep"){
  
  const fetchRetailers = async () => {
  const response = await fetch(
      `http://192.168.29.5:8080/api/v1/retailer/${props.id}/orders`
    );
   const data = await response.json();
   console.log(data);
    setlist(data.content);
  };


  useEffect(() => {
    fetchRetailers();
  }, []);}
    return(
        <table className="table table-hover">
        <thead> 
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Phone No.</td>
                <td>Business Name</td>
                <td>Address</td>
            </tr>
        </thead>
        <tbody>
            {list.map((data)=><tr key={data.id}>
                <td>{data.id}</td>
                <td>{data.name}</td>
                <td>{data.phoneNo}</td>
                <td>{data.businessName}</td>
                <td>{data.address.city}</td>
            </tr>)}
        </tbody>
        </table>
    );

};
export default RepresentativeRetailers;