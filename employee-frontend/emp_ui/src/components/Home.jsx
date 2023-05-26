import React, { useEffect } from "react";
import { useState } from "react";
import empService from "../service/emp.service";
import { Link } from "react-router-dom";

const Home = () => {
  const [empList, setEmpList] = useState([]);

  const [msg, setMsg] = useState("");

  useEffect(() => {
    init();
  }, []);

  const init = () => {
    empService
      .getAllEmp()
      .then((res) => {
        console.log(res.data);
        setEmpList(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const deleteEmployee = (id) => {
    empService
      .deleteEmp(id)
      .then((res) => {
        setMsg("Delete Successfully");
        init();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <h1 className="text-center mt-4">Emp Portal</h1>
      {msg && <p className="text-success text-center">{msg}</p>}
      <table className="table mt-4">
        <thead className="bg-light">
          <tr>
            <th scope="col">Serial No</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Salary</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {empList.map((e, index) => (
            <tr>
              <th scope="row">{index + 1}</th>
              <td>{e.firstName}</td>
              <td>{e.lastName}</td>
              <td>{e.email}</td>
              <td>{e.address}</td>
              <td>{e.salary}</td>
              <td>
                <Link
                  to={"/editEmp/" + e.id} // dynamic value
                  className="btn btn-primary btn-sm"
                >
                  Edit
                </Link>
                <a
                  onClick={() => deleteEmployee(e.id)}
                  className="btn btn-danger btn-sm ms-2"
                >
                  Delete
                </a>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Home;
