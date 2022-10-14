import "./Report.css";
import React from "react";
const Report = (props) => {
  return (
    <center>
      <br/><br/>
      {props.type==="rep" &&<form className="my-form">
        <table className="report-table">
          <tbody>
          <tr>
            <td>
              <label>Number of {props.type} Met:</label>
            </td>
            <td>
              <input type="number" max={100} min={0}></input>
            </td>
          </tr>
          <tr>
            <td>
              <label>Number of {props.type} Onboarded:</label>
            </td>
            <td>
              <input type="number" max={100} min={0}></input>
            </td>
          </tr>
          <tr>
            <td>
              <label>Number of Previous {props.type} Met:</label>
            </td>
            <td>
              <input type="number" max={100} min={0}></input>
            </td>
          </tr>
          <tr>
            <td>
              <label>Number of orders placed:</label>
            </td>
            <td>
              <input type="number" max={100} min={0}></input>
            </td>
          </tr>
          <tr>
            <td>
              <label>Comments:</label>
            </td>
            <td>
              <textarea
                type="text"
                cols="40"
                rows="5"
                style={{ width: "250px", height: "150px" }}
                name="comments"
              />
            </td>
          </tr>
          <tr>
            <td colSpan={2}>
              <button type="submit" className="btn btn-primary">
                Submit Report
              </button>
            </td>
          </tr>
          </tbody>
        </table>
      </form>}
      {props.type==="man" && <h1>representative lists with reports</h1>}
    </center>
  );
};
export default Report;
