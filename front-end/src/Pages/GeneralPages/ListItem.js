import { useNavigate } from "react-router-dom";
import React from "react";
const ListItem=(props)=>{

    const navigate=useNavigate();
    const ClickHandler=()=>{
        // eslint-disable-next-line
        navigate("/AssociatedRetailers/"+`${props.item.UID}`)
    }
    return(
        <tr onClick={ClickHandler} key={props.item.UID}>
            <td>{props.item.name}</td>
            <td>{props.item.phone}</td>
            <td>{props.item.UID}</td>
            {props.type==="Distributor" && <td>{props.item.ERP}</td>}
            <td>{props.item.Address.street}</td>
            <td>{props.item.Address.city}</td>
            <td>{props.item.Address.pincode}</td>
            <td>{props.item.Address.state}</td>
            <td>{props.item.Address.country}</td>
        </tr>
    );
};
export default ListItem;