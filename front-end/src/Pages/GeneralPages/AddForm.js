import "./AddForm.css";
import React from "react";
import { useNavigate } from "react-router-dom";
const AddForm = (props) => {
  const navigate=useNavigate();
  const submitHandler=(event)=>{
    event.preventDefault();
    navigate("/NewRetailer");
  }
  return (
      <form onSubmit={submitHandler}>
        <center>
          <table className="new-retailer-table ">
            <thead className="new-form-header text-center">
              <tr colSpan={2}  >
              <td >New {props.type}</td>
              </tr>
            </thead>
            <tbody>
              <tr className="UserName">
                <td>
                  <label>Name:</label>
                </td>
                <td>
                  <input type="text" ></input>
                </td>
              </tr>
              <tr className="Phone">
                <td>
                  <label>Phone Number:</label>
                </td>
                <td>
                  <input
                    type="tel"
                    pattern="[6-9]{1}[0-9]{9}"
                    maxLength={10}
                  ></input>
                </td>
              </tr>
              {props.type === "Distributor" && (
                <tr className="ERP">
                  <td>
                    <label>ERP:</label>
                  </td>
                  <td>
                    <input type="text"></input>
                  </td>
                </tr>
              )}
              <tr className="Colony">
                <td>
                  <label>Street:</label>
                </td>
                <td>
                  <input type="text"></input>
                </td>
              </tr>
              <tr className="city">
                <td>
                  <label>City:</label>
                </td>
                <td>
                  <input type="text"></input>
                </td>
              </tr>
              <tr className="pincode">
                <td>
                  <label>pincode:</label>
                </td>
                <td>
                  <input type="tel" maxLength={6}></input>
                </td>
              </tr>
              <tr className="state">
                <td>
                  <label>State:</label>
                </td>
                <td>
                  <input type="text"></input>
                </td>
              </tr>
              <tr className="country">
                <td>
                  <label>Country:</label>
                </td>
                <td>
                  <input type="text"></input>
                </td>
              </tr>
              <tr className="submit-button text-center" >
                <td colSpan={2}>
                  <button
                    type="submit"
                    value="submit"
                    className="btn btn-primary"
                    width="40px"
                  >
                    Submit
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </center>
      </form>
  );
};
export default AddForm;
