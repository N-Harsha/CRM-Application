import Card from "../../UI/Card";
import React, { useState } from "react";
const Comments = () => {
  const [ comments,setcomments] = useState([
    {
      Name: "SRI MAYURA MEDICAL AGENCIES",
      Text: "Nice Service thank you for your fast response and delivery",
      Date: "12/8/2022",
    },
    {
      Name: "SRI Medical Agencies",
      Text: "Nice thank you for your fast response and delivery",
      Date: "12/8/2022",
    },
    {
      Name: "SRI MAYURA MEDICAL AGENCIES",
      Text: "Nice Service thank you your fast response and delivery",
      Date: "12/8/2022",
    },
    {
      Name: "SRI MAYURA MEDICAL AGENCIES",
      Text: "Nice Service thank you for your response and delivery",
      Date: "12/8/2022",
    },
  ]);
  const commentsubmitHandler=(event)=>{
    event.preventDefault();
    const myobj={
      Name:"Representative",
      Text:event.target[0].value,
      Date:new Date().toDateString(),
    }
    setcomments([...comments,myobj]);
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
    {comments.map((data)=><tr key={data.Date+data.Text+new Date()}><Card data={data}></Card></tr>)}
    </tbody>
    </table>
    </>
  );
};
export default Comments;
