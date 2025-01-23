import React, { useEffect, useState } from "react";
import empService from "../service/emp.service";
import { useNavigate, useParams } from "react-router-dom";

const EditEmployee = () => {
  const [emp, setEmp] = useState({
    id : "",
    firstName: "",
    lastName: "",
    email: "",
    address: "",
    salary: "",
  });

  const [msg, setMsg] = useState("");

  const data = useParams();
  // console.log(data.id)

  const navigate = useNavigate();



  useEffect(() => {
    empService.getEmpById(data.id).then((res) =>{
      setEmp(res.data)
    }).catch((error) =>{
      console.log(error)
    })
  },[])

  const handleChange = (e) => {
    const value = e.target.value;
    setEmp({ ...emp, [e.target.name]: value });
  };

  const updateEmp = (e) => {
    e.preventDefault();
    empService.updateEmp(emp.id,emp).then((res) =>{
      navigate("/");
    }).catch((error) =>{
      console.log(error);
    })

    
  };
  return (
    <div className="conatiner">
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <div className="card">
            <div className="card-header text-center fs-3">
             Edit Employee
              {msg && <p className="text-success">{msg}</p>}
            </div>
            <div className="card-body">
              <form onSubmit={(e) => updateEmp(e)}>
                <div className="mb-3">
                  <label className="">Enter First Name</label>
                  <input
                    type="text"
                    className="form-control"
                    name="firstName"
                    value={emp.firstName}
                    onChange={(e) => handleChange(e)}
                  />
                </div>

                <div className="mb-3">
                  <label className="">Enter Last Name</label>
                  <input
                    type="text"
                    className="form-control"
                    name="lastName"
                    value={emp.lastName}
                    onChange={(e) => handleChange(e)}
                  />
                </div>

                <div className="mb-3">
                  <label className="">Enter Email</label>
                  <input
                    type="email"
                    className="form-control"
                    name="email"
                    value={emp.email}
                    onChange={(e) => handleChange(e)}
                  />
                </div>

                <div className="mb-3">
                  <label className="">Enter Address</label>
                  <input
                    type="text"
                    className="form-control"
                    name="address"
                    value={emp.address}
                    onChange={(e) => handleChange(e)}
                  />
                </div>

                <div className="mb-3">
                  <label className="">Enter Salary</label>
                  <input
                    type="number"
                    className="form-control"
                    name="salary"
                    value={emp.salary}
                    onChange={(e) => handleChange(e)}
                  />
                </div>

                <div className="text-center">
                  <button className="btn btn-success">Submit</button>
                  <button
                    type="reset"
                    className="btn btn-danger ms-2"
                    value="reset"
                  >
                    Reset
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EditEmployee;
