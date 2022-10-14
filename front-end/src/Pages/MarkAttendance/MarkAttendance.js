import "./MarkAttendance.css";
import React from "react";
import { Calendar } from "react-calendar";
import moment from "moment";
import { useState } from "react";
import "./Calendar.css";
const MarkAttendance = () => {
  const date = new Date();
  const [mark, setmark] = useState(["12-10-2022", "11-10-2022", "25-08-2022"]);
  const attendanceHandler = (event) => {
    event.preventDefault();
    const today =
      (date.getDate() > 9 ? date.getDate() : "0" + date.getDate()) +
      "-" +
      (date.getMonth() > 8
        ? date.getMonth() + 1
        : "0" + (date.getMonth() + 1)) +
      "-" +
      date.getFullYear();
    setmark([...mark, today]);
  };
  return (
    <div>
      <Calendar
        value={date}
        tileClassName={({ date, view }) => {
          if (mark.find((x) => x === moment(date).format("DD-MM-YYYY"))) {
            return "highlight";
          }
        }}
      />
      <br />
      <br />
      <button
        className={"btn btn-primary"}
        type="submit"
        onClick={attendanceHandler}
      >
        Mark Attendance
      </button>
    </div>
  );
};
export default MarkAttendance;
