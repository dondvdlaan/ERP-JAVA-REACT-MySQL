import { ReactElement } from "react";
import { Navigate, Route, Routes } from "react-router-dom";

import Inventory from "./inventory/Inventory";
import Orders from "./orders/Orders";
import { Dash } from "./Dash";
import ProTip from "./ProTip";

export default function Routing(): ReactElement {

    return (
      <Routes>
        <Route path="/inventory"  element={<Inventory />} />
        <Route path="/orders"     element={<Orders />} />
        <Route path="/test"       element={<ProTip />} />


        <Route path="/home"       element={<Dash />} />
        <Route path="/"           element={<Navigate to="/home" />} />
      </Routes>
    );
  }