import { configureStore, createSlice } from "@reduxjs/toolkit";
import React from "react";
const retailerSlice=createSlice({
    name : "retailer",
    initialState : {
        isLoggedIn:false,
        uname:"rep"
    },
    reducers : {
        loginReducer(state) {
            state.isLoggedIn=!state.isLoggedIn;
        }, 
        repReducer(state){
            state.uname="rep";
        },
        manreducer(state){
            state.uname="man";
        }

    }
});
const store = configureStore({
    reducer : { retailer : retailerSlice.reducer}
})

export const retailerActions  = retailerSlice.actions;
export default store;