import { Button } from '@/components/ui/button'
import { Dialog, DialogContent, DialogFooter, DialogHeader, DialogTitle } from '@/components/ui/dialog'
import { Input } from '@/components/ui/input'
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table'
import React from 'react'
import CustomerForm from './CustomerForm'

const Customers = [
  {
    id: 1,
    fullName: "John Doe",
    phone: "123-456-7890",
    email: "john@example.com"
  },
  {
    id: 2,
    fullName: "Jane Smith",
    phone: "987-654-3210",
    email: "jane@example.com"
  },
  {
    id: 3,
    fullName: "Alice Johnson",
    phone: "987-654-3210",
    email: "alice@example.com"
  }
];

const CustomerDialog = ({ showCustomerDialog, setShowCustomerDialog }) => {

  const[showCustomerForm, setShowCustomerForm] = React.useState(false);

  const handleSelectCustomer = (customer) => {
    console.log("selected customer:", customer);
    // Logic to select customer
    setShowCustomerDialog(false);
  }
  return (
    <Dialog open={showCustomerDialog} onOpenChange={setShowCustomerDialog}>
      <DialogContent className={"max-w-2xl"}>
        <DialogHeader>
          <DialogTitle>Select Customer</DialogTitle>
        </DialogHeader>

        <div className="mb-4">
          <Input placeholder='Search customer' />
        </div>

        <div className="max-h-96 overflow-y-auto">
          <Table>
            <TableHeader>
              <TableRow>
                <TableHead className="w-[150px]">Name</TableHead>
                <TableHead className="w-[150px]">Phone</TableHead>
                <TableHead className="w-[150px]">Email</TableHead>
              </TableRow>
            </TableHeader>

            <TableBody>
              {Customers.map((customer) => (
                <TableRow key={customer.id}>
                  <TableCell>{customer.fullName}</TableCell>
                  <TableCell>{customer.phone}</TableCell>
                  <TableCell>{customer.email}</TableCell>
                  <TableCell>
                    <Button variant={"outline"} className={"w-full"}
                      onClick={() => handleSelectCustomer(customer)}>
                      Select
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </div>

        <CustomerForm
          showCustomerForm={showCustomerForm}
          setShowCustomerForm={setShowCustomerForm}
         />

        <DialogFooter>
          <Button onClick={() => setShowCustomerForm(true)}>
            Add New Customer
          </Button>
        </DialogFooter>

        
      </DialogContent>
    </Dialog>
  )
}

export default CustomerDialog