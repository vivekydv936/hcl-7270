import './App.css'
import SampleCode from './component/SampleCode'
import UseFetchApi from './component/UseFetchApi'

function App() {
  const employee = [
    {
    ename: 'rahul',
    empid: '1208',
  },
  {
    ename: 'aman',
    empid: '1212',
  },
  {
    ename: 'saurav',
    empid: '55',
  }
]

  return (
    <div>
      {/* <h2>welcome to hrms system</h2>
      <div>
        {employee.map((ele) => (
          <SampleCode key={ele.empid} empdata={ele} />
        ))}

      </div> */}

         <SampleCode/>
         <UseFetchApi/>
      

    </div>
  )
}

export default App
