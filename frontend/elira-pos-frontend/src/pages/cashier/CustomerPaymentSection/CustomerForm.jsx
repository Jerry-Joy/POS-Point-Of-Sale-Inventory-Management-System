import { Button } from '@/components/ui/button';
import { Dialog, DialogContent, DialogHeader, DialogTitle } from '@/components/ui/dialog'
import { Input } from '@/components/ui/input';
import { Formik, Form } from 'formik';
import React from 'react'

const CustomerForm = ({showCustomerForm, setShowCustomerForm}) => {

  const initialValues={
    fullName: "",
    phone: "",
    email: ""
  }
  return (
    <Dialog open={showCustomerForm} onOpenChange={setShowCustomerForm}>
      <DialogContent className={"max-w-md"} >
        <DialogHeader>
          <DialogTitle>Add New Customer</DialogTitle>
        </DialogHeader>

        <Formik
          initialValues={initialValues}
          onSubmit={(values) => {
            console.log("Form Submitted:", values);
          }}
        >
          {({ values, handleChange, handleBlur}) => (
            <Form className="space-y-5">
              <div>
                <Input
                  name="fullName"
                  placeholder="Full Name"
                  value={values.fullName}
                  onChange={handleChange}
                  onBlur={handleBlur}
                />
              </div>
              <div>
                <Input
                  name="phone"
                  placeholder="Phone"
                  value={values.phone}
                  onChange={handleChange}
                  onBlur={handleBlur}
                />
              </div>
              <div>
                <Input
                  name="email"
                  placeholder="Email"
                  value={values.email}
                  onChange={handleChange}
                  onBlur={handleBlur}
                />
              </div>
              <Button type="submit" className="w-full">Add Customer</Button>
            </Form>
          )}
          
        </Formik>
      </DialogContent>
    </Dialog>
  );
}

export default CustomerForm