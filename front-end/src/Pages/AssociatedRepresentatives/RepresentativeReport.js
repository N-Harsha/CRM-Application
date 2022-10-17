import React from "react";
import { useState, useEffect } from "react";
const RepresentativeReport = (props) => {
  const [list, setlist] = useState([]);
  const token = localStorage.getItem("token");
  const fetchRetailerreports = async () => {
    const response = await fetch(
      `http://localhost:8080/api/v1/representatives/${props.id}/reports`,
      {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          "Access-Control-Allow-Origin": "*",
          Authorization: "Bearer " + token,
        },
      }
    );
    const data = await response.json();
    console.log(data.content);
    setlist(data.content);
  };
  useEffect(() => {
    fetchRetailerreports();
  }, []);
  return (
    <table className="table table-hover">
      <thead>
        <tr>
          <td>Date</td>
          <td>Total Retailers Met</td>
          <td>New Retailer Onbaorded</td>
          <td>Previous Retailers Met</td>
          <td>Orders Placed</td>
          <td>Comments</td>
        </tr>
      </thead>
      <tbody>
        {list.map((data) => (
          <tr key={data.id}>
            <td>{data.id}</td>
            <td>{data.totalMet}</td>
            <td>{data.newOnboarded}</td>
            <td>{data.existingMet}</td>
            <td>{data.ordersPlaced}</td>
            <td>{data.comment}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};
export default RepresentativeReport;
