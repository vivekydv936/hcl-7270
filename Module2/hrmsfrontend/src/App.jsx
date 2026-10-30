import './App.css'
import Home from './component/Home'
import Login from './component/Login'
import Registrstion from './component/Registrstion'
import SampleCode from './component/SampleCode'
import UseFetchApi from './component/UseFetchApi'
import {BrowserRouter, Route, Routes} from 'react-router-dom'



function App() {


  return (
    <div>
     <BrowserRouter>
     <Routes>
     <Route path ='/'element={<Home/>}>    </Route>
     <Route path ='/login'element={<Login/>}>    </Route>
     <Route path ='/register'element={<Registrstion/>}>    </Route>

    </Routes>
     </BrowserRouter>



    </div>
  )
}

export default App
