import React from "react";
const Orders=()=>{
    const orders=[{
        orderId:"67853",
        productName:"1 AL 5MG TABS",
        supplierName:"TRINETRA MEDICAL AGENCIES",
        amount:568.93
    },{
        orderId:"1234",
        productName:"ACELO NITRO PHENONE",
        supplierName:"TRINETRA MEDICAL AGENCIES",
        amount:2897.56
    },{
        orderId:"6783",
        productName:"DOLO 650 ",
        supplierName:"SRI MAYURA MEDICAL AGENCIES",
        amount:7845.15
    },{
        orderId:"7853",
        productName:"GLYCOMET SR 500MG",
        supplierName:"SRI BHADRA MEDICAL DISTRIBUTORS",
        amount:485
    }];
    return(
        <table className="table table-hover">
        <thead>
            <tr>
                <td>Order Id</td>
                <td>Product Name</td>
                <td>Supplier Name</td>
                <td>Amount(in Rs.)</td>
            </tr>
        </thead>
        <tbody>
            {orders.map((data)=><tr key={data.orderId}>
                <td>{data.orderId}</td>
                <td>{data.productName}</td>
                <td>{data.supplierName}</td>
                <td>{data.amount}</td>
            </tr>)}
        </tbody>
        </table>
    );
};
export default Orders;