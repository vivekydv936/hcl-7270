import './SampleCode.css'
import React,{useState,useEffect} from 'react'



function SampleCode({ empdata }) {
    const [counter ,setCounter]=useState(1)
     const [pointer ,setpointer]=useState(100)

    useEffect(()=>{
        console.log("component is rendering");
        console.log("counter="+counter)
        console.log("pointer="+pointer)
    },[counter,pointer]
    )


    function changeCounter(){
        setCounter(counter+2);
        
    }

    function changePointer(){
         setpointer(pointer-2)
    }


  return (
    <div className="employee-card">

      {/* <h2 className="employee-card__title">Employee Details</h2>
      <div className="employee-card__info">
        <p><strong>Name:</strong> {empdata.ename}</p>
        <p><strong>EmpId:</strong> {empdata.empid}</p>
      </div> */}
     <h2> counter {counter} </h2>
     <h2> pointer {pointer} </h2>
     <button onClick={changeCounter}> Counter</button>
     <button onClick={changePointer}> Pointer</button>



    </div>
  )
}

export default SampleCode