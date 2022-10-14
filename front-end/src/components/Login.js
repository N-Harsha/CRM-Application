import React from "react";
import "mdb-react-ui-kit/dist/css/mdb.min.css";
import "./Login.css";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { retailerActions } from "../store";
const Login = (props) => {
  const user=useSelector(state=>state.retailer);
  const dispatch=useDispatch();
  const history = useNavigate();
  const submitHandler = (event) => {
    event.preventDefault();
    console.log(event);
    if(event.target[0].value==="rep"){
      dispatch(retailerActions.repReducer());
    }
    if(event.target[0].value==="man"){
      dispatch(retailerActions.manreducer());
    }
    props.onClick();
    history("/dashboard");
  };
  return (
    <div>
      <img
        className="crm_logo"
        src={require("../Images/crm_logo.jpg")}
        alt={"Logo"}
        style={{ width: 150, height: 150, alignContent: "center" }}
      />
      <form onSubmit={submitHandler} className="crm-login-form">
        <div>
          <label className="username-label">Username:</label>
        </div>
        <br />
        <div>
          <input type="text" className="username-textbox"></input>
        </div>
        <br />
        <div>
          <label className="password-label">Password:</label>
        </div>
        <br />
        <div>
          <input type="password" className="password-textbox"></input>
        </div>
        <br />
        <div>
          <button className="btn btn-primary mylogin" type="submit">
            Login
          </button>
        </div>
      </form>
    </div>
  );
};
export default Login;
