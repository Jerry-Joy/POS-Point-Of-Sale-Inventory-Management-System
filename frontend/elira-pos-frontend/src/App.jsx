
import './App.css'
import CreateOrder from './pages/cashier/CreateOrder'
import CustomerLookup from './pages/cashier/Customer Management/CustomerLookup'
import OrderHistory from './pages/cashier/Order History/OrderHistory'
import ShiftSummaryPage from './pages/cashier/Shift Report/ShiftSummaryPage'

function App() {

  return (
    <>
      {/* {<CreateOrder />} */}
      {/* {<CustomerLookup />} */}
      {/* {<ShiftSummaryPage />} */}
      <OrderHistory />  
    </>
  )
}

export default App
