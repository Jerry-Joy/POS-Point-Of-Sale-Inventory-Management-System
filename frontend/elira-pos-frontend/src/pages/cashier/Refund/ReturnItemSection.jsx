import { Button } from '@/components/ui/button'
import { Card, CardContent } from '@/components/ui/card'
import { Label } from '@/components/ui/label'
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from '@/components/ui/select'
import { Textarea } from '@/components/ui/textarea'
import React from 'react'

const returnReasons = [
  "Damaged Item",
  "Wrong Item Sent",
  "Better Price Available",
  "No Longer Needed",
  "Other"
];

const refundMethods = [
  "CASH",
  "CREDIT_CARD",
  "MOMO",
  "BANK_TRANSFER"
]

const ReturnItemSection = ({selectedOrder}) => {
  const [returnReason, setReturnReason] = React.useState("");
  const [otherReason, setOtherReason] = React.useState("");
  const [refundMethod, setRefundMethod] = React.useState("CASH");
  return (
    <div className="p-4 w-1/2">
      <Card className={"mt-4"} >
        <CardContent className={"p-4"} >
          <div className="space-y-4">
            <div className="">
              <Label className={"mb-2 block"} >Return Reason</Label>
              <Select value={returnReason}
                onValueChange={(value) => setReturnReason(value)} >
                <SelectTrigger className={"w-full"}>
                  <SelectValue placeholder="Select A Reason..." />
                </SelectTrigger>

                <SelectContent>
                  {returnReasons.map((reason) => <SelectItem key={reason} value={reason}>
                    {reason}
                  </SelectItem>)}
                </SelectContent>
              </Select>
            </div>
            {returnReason === "Other" && (<div>
              <Label className={"mb-2 block"} >
                Please specify reason
              </Label>
              <Textarea
              id="other-reason"
              placeholder="Please specify your reason here"
              value={otherReason}
              onValueChange={(value)=>setOtherReason(value)} />
            </div>
            )}
            <div className="">
              <Label>
                Refund Method
              </Label>
              <Select value={refundMethod}
                onValueChange={(value) => setRefundMethod(value)} >
                <SelectTrigger className={"w-full"}>
                  <SelectValue placeholder="Select A Refund Method..." />
                </SelectTrigger>

                <SelectContent>
                  {refundMethods.map((method) => <SelectItem key={method} value={method}>
                    {method}
                  </SelectItem>)}
                </SelectContent>
              </Select>
            </div>

            <div className="pt-5 border-t">
              <div className="flex justify-between font-semibold text-lg">
                <span className="">Total Refund Amount</span>
                <span className="">${selectedOrder.totalAmount}</span>
              </div>

              <Button className="w-full py-6 mt-5">
                Process Refund
              </Button>
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  )
}

export default ReturnItemSection