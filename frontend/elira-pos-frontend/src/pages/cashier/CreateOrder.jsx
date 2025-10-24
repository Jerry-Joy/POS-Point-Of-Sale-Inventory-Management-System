import React from 'react'
import ProductSection from './ProductSection/ProductSection'
import CartSection from './CartSection/CartSection'
import CustomerPaymentSection from './CustomerPaymentSection/CustomerPaymentSection'

const CreateOrder = () => {
  return (
    <div className='flex-1 flex overflow-hidden'>
      <ProductSection />
      <CartSection />
      <CustomerPaymentSection />
    </div>
  )
}

export default CreateOrder