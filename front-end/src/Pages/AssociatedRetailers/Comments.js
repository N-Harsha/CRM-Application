import Card from "../../UI/Card";
import React, { useState,useEffect } from "react";
const Comments = (props) => {
  const [list,setlist]=useState([]);
  if(props.type==="rep"){
  
  const fetchRetailerorders = async () => {
  const response = await fetch(
      `http://192.168.29.5:8080/api/v1/retailer/${props.id}/comments`
    );
   const data = await response.json();
   console.log(data);
    setlist(data);
  };


  useEffect(() => {
    fetchRetailerorders();
  }, []);}
  const commentsubmitHandler=(event)=>{
    event.preventDefault();
    const myobj={
      Name:"Representative",
      Text:event.target[0].value,
      Date:new Date().toDateString(),
    }
    setlist([...list,myobj]);
  };
  return(
    <>
    <form onSubmit={commentsubmitHandler}>
        <textarea rows={4} cols={100} className="comment"></textarea>
        <br></br><br></br>
        <button type="submit" className="btn btn-primary"> Add Comment</button>
    </form>
    <table className="table">
        <tbody>
    {list.map((data)=><tr key={data.date+data.Text+new Date()}><Card data={data}></Card></tr>)}
    </tbody>
    </table>
    </>
  );
};
export default Comments;
