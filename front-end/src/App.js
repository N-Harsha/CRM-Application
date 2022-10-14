import "./App.css";
import { Route, Routes, Navigate } from "react-router-dom";
import {useSelector,useDispatch} from "react-redux";
import { retailerActions } from "./store";
import Login from "./components/Login";
import React from "react";
import DashBoard from "./components/DashBoard";
import NavBar from "./components/NavBar";
import AssociatedRetailers from "./Pages/AssociatedRetailers/AssociatedRetailers";
import NewRetailer from "./Pages/NewRetailer/NewRetailer";
import AddForm from "./Pages/GeneralPages/AddForm";
import Report from "./Pages/Reports/Report";
import Dummy from "./Pages/AssociatedRetailers/Dummy";
import Calendar from "./Pages/MarkAttendance/Calendar";
function App() {
  const retailer=useSelector(state=>state.retailer);
  const dispatch=useDispatch();
  const LoginHandler=(event)=>{
    dispatch(retailerActions.loginReducer());

  }
  const uname=retailer.uname;
  return (
    <div className="Appdiv text-center">
      {uname==="rep" && retailer.isLoggedIn && <NavBar onClick={LoginHandler} type="ret"/>}
      {uname==="man" && retailer.isLoggedIn && <NavBar onClick={LoginHandler} type="man"/>}
      <div className="route-div">
       {uname==="rep" &&  <Routes>
          <Route path="/" element={<Navigate to="/login" />} />
          <Route path="/login" element={<Login onClick={LoginHandler}/>} />
          <Route path="/dashboard" element={<DashBoard />} />
          <Route path="/AssociateRetailers/" element={<AssociatedRetailers type="Retailer"/>} />
          <Route path="/AssociatedRetailers/:UID" element={<Dummy/>}></Route>
          <Route path="/MarkAttendance" element={<Calendar />} />
          <Route path="/Reports" element={<Report type="Retailer" />} />
          <Route path="/NewRetailer" element={<NewRetailer type="Retailer"/>} />
          <Route
            path="/NewRetailer/new"
            element={<AddForm type="Retailer" />}
          />
        </Routes>}
          {uname==="man"&& <Routes>
          <Route path="/" element={<Navigate to="/login" />} />
          <Route path="/login" element={<Login onClick={LoginHandler}/>} />
          <Route path="/dashboard" element={<DashBoard />} />
          <Route path="/AssociateDistributors/" element={<AssociatedRetailers type="Distributor"/>} />
          <Route path="/AssociatedDistributors/:UID" element={<Dummy/>}></Route>
          <Route path="/MarkAttendance" element={<Calendar />} />
          <Route path="/Reports" element={<Report type="Distributor" />} />
          <Route path="/NewDistributor" element={<NewRetailer type="Distributor"/>} />
          <Route
            path="/NewDistributor/new"
            element={<AddForm type="Distributor" />}
          />
        </Routes>}
      </div>
    </div>
  );
}

export default App;
