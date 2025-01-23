import 'bootstrap/dist/css/bootstrap.min.css';


import '../src/App.css'
import Navbar from './components/Navbar';
import AddEmployee from './components/AddEmployee';
import { Routes,Route } from 'react-router-dom';
import Home from './components/Home';
import EditEmployee from './components/EditEmployee';

function App() {
  return (
    <div className="App">

      <Navbar></Navbar>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/add-employee" element={<AddEmployee/>}
        ></Route>
        <Route path="/edit-employee/:id" element={<EditEmployee/>}
        ></Route>
        
      </Routes>
    </div>
  );
}

export default App;
