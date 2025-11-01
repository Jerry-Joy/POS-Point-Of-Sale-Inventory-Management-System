
import { Route, Routes } from 'react-router-dom'
import './App.css'
import CreateOrder from './pages/cashier/CreateOrder'
import CustomerLookup from './pages/cashier/Customer Management/CustomerLookup'
import OrderHistory from './pages/cashier/Order History/OrderHistory'
import RefundPage from './pages/cashier/Refund/RefundPage'
import ShiftSummaryPage from './pages/cashier/Shift Report/ShiftSummaryPage'
import CashierRoutes from './routes/CashierRoutes'

function App() {

  return (
    <>
      <Routes>
        <Route path='/cashier/*' element={<CashierRoutes />} />
      </Routes>
    </>
  )
}

export default App
