import "./AddButton.css";
import React from "react";
const AddButton=(props)=>{
    return(
        <center><br /><button className="crmButton btn btn-primary" onClick={props.onClick}>Add {props.title}<br /></button></center>
    );
};
export default AddButton;