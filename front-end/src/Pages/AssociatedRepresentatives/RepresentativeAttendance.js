import React from "react";
import { useState,useEffect } from "react";
import { Calendar } from "react-calendar";
import moment from "moment";
const RepresentativeAttendance=()=>{
    const date=new Date();
    const [mark, setmark] = useState([]);
  const fetchdatelist = async () => {
    const response = await fetch(
      "http://192.168.29.5:8080/api/v1/manager/1/representatives"
    );
    const data = await response.json();
    setmark(data);
  };

  useEffect(() => {
    fetchdatelist();
  }, []);
  return(
    <div>
      <Calendar
        value={date}
        tileClassName={({ date, view }) => {
          if (mark.find((x) => x === moment(date).format("YYYY-MM-DD"))) {
            return "highlight";
          }
        }}
      />
      </div>
  );
};
export default RepresentativeAttendance;