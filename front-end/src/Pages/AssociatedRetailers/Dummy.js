import "./Dummy.css";
import Orders from "./Orders";
import Comments from "./Comments";
import React from "react";
import {useState} from "react";
const Dummy = () => {
  const[orders,setorders]=useState(true);
  const OrdersHandler=()=>{
      setorders(true);
  }
  const CommentsHandler=()=>{
      setorders(false);
  }
  return (
    <div className="nav-for-retailers">
      <table className="associated-retailer-table">
        <tbody>
          <tr>
            <td>
              {" "}
              <button type="button" className="btn btn-primary" onClick={OrdersHandler}>
                Orders
              </button>
            </td>
            <td>
              <button type="button" className="btn btn-primary" onClick={CommentsHandler}>
                Comments
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      {orders && <Orders></Orders>}
      {!orders && <Comments></Comments>}
    </div>
  );
};
export default Dummy;
