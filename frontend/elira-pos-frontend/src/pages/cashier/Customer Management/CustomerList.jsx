import React from 'react'
import CustomerCard from './CustomerCard'

const customers = [
  {
    id: 1,
    fullName: 'John Doe',
    email: 'john@example.com',
    phone: '123-456-7890',
    loyaltyPoints: 120,
    totalOrders: 15,
    totalSpent: 1500,
    averageOrderValue: '100'
  },
  {
    id: 2,
    fullName: 'Jane Smith',
    email: 'jane@example.com',
    phone: '234-567-8901',
    loyaltyPoints: 85,
    totalOrders: 8,
    totalSpent: 800,
    averageOrderValue: '100'
  },
  {
    id: 3,
    fullName: 'Bob Johnson',
    email: 'bob@example.com',
    phone: '345-678-9012',
    loyaltyPoints: 200,
    totalOrders: 20,
    totalSpent: 2500,
    averageOrderValue: '125'
  },
  {
    id: 4,
    fullName: 'Alice Brown',
    email: 'alice@example.com',
    phone: '456-789-0123',
    loyaltyPoints: 150,
    totalOrders: 12,
    totalSpent: 1200,
    averageOrderValue: '100'
  }
]

const CustomerList = ({setSelectedCustomer}) => {
  return (
    <div className="flex-1 overflow-auto">
      <div className="divide-y">
        {customers.map((customer) => (
          <CustomerCard
          className="cursor-pointer hover:bg-accent"
           setSelectedCustomer={setSelectedCustomer}
           key={customer.id} customer={customer} />
        ))}
      </div>
    </div>
  )
}

export default CustomerList