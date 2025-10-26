import { Button } from '@/components/ui/button'
import { Pause, ShoppingCart, Trash2 } from 'lucide-react'
import React from 'react'
import CartItem from './CartItem'
import CartSummary from './CartSummary';
import HeldOrderDialog from './HeldOrderDialog';

const CartItems = [
  {
    name: "Men Slim Fit Casual Shirt(Pack of 2)",
    sku: "SHRT-S-COTTON-BLACK-2025",
    quantity: 2,
    sellingPrice: 10.00
  },
  {
    name: "Men Slim Fit Casual Shirt(Pack of 2)",
    sku: "SHRT-S-COTTON-BLACK-2025",
    quantity: 2,
    sellingPrice: 10.00
  },
  {
    name: "Men Slim Fit Casual Shirt(Pack of 2)",
    sku: "SHRT-S-COTTON-BLACK-2025",
    quantity: 2,
    sellingPrice: 10.00
  }
];

const CartSection = () => {
  const [showHeldOrdersDialog, setShowHeldOrdersDialog] = React.useState(false);
  return (
    <>
    <div className='border-r w-2/5 flex flex-col bg-card'>

      <div className="p-4 border-b bg-muted">
        <div className="flex items-center justify-between">
          <h2 className="text-lg font-semibold flex items-center">
            <ShoppingCart />
            Cart ( {3} ) Items
          </h2>

          <div className="flex space-x-2">
            <Button onClick={() => setShowHeldOrdersDialog(true)}
             variant={"outline"} className="" size={"sm"}>
              <Pause className='w-4 h-4 mr-1' />
              Hold
            </Button>

             <Button variant={"outline"} className="" size={"sm"}>
              <Trash2 className='w-4 h-4 mr-1' />
              Clear
            </Button>
          </div>
        </div>

      </div>

      <div className="p-4 space-y-3">
        {CartItems.map((item, index) => (
          <CartItem item={item} key={index} />
        ))}
      </div>

      <CartSummary />
    </div>
    <HeldOrderDialog
      showHeldOrdersDialog={showHeldOrdersDialog}
      setShowHeldOrdersDialog={setShowHeldOrdersDialog}
     />
    </>
  )
}

export default CartSection